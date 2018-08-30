import {
  Component,
  OnInit,
  EventEmitter,
  Output,
  ViewChild,
  Input,
} from '@angular/core';
import {
  NgbModalRef,
  NgbActiveModal,
  NgbModal,
} from '@ng-bootstrap/ng-bootstrap';
import { Reimbursement } from '../../../reimbursement';
import { ReimbursementType } from '../../../reimbursement-type.enum';
import { ReimbursementStatus } from '../../../reimbursement-status.enum';
import { UserService } from '../../../user.service';
import { of, zip, Observable } from 'rxjs';
import { tap, map } from 'rxjs/operators';

@Component({
  selector: 'app-reimbursement-details-modal',
  templateUrl: './reimbursement-details-modal.component.html',
  styleUrls: ['./reimbursement-details-modal.component.css'],
})
export class ReimbursementDetailsModalComponent implements OnInit {
  @Output()
  close = new EventEmitter<void>();
  /**
   * An event fired when one of the resolution buttons is clicked. The event
   * emitted is a boolean specifying whether the reimbursement was approved (if
   * false, it was denied).
   */
  @Output()
  resolve = new EventEmitter<boolean>();
  @Input()
  showAdminControls = false;
  reimbursement: Reimbursement;
  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  // These strings have to be fetched using the user service.
  authorName: string;
  resolverName: string;

  constructor(
    private userService: UserService,
    private modalService: NgbModal
  ) {}

  ngOnInit() {}

  closeModal(): void {
    this.modal.close();
    this.close.emit();
  }

  handleResolution(resolved: boolean): void {
    this.modal.close();
    this.resolve.emit(resolved);
  }

  open(r: Reimbursement): void {
    this.reimbursement = r;
    // If we're an admin, we need to get the names of the author and resolver
    // before opening the modal.
    const getAuthorName: Observable<string> = this.showAdminControls
      ? this.userService
          .getById(this.reimbursement.authorId)
          .pipe(map(author => `${author.firstName} ${author.lastName}`))
      : of('');
    // Make sure we only get the resolver name if there is one.
    const getResolverName: Observable<string> =
      this.showAdminControls && this.reimbursement.resolverId
        ? this.userService
            .getById(this.reimbursement.resolverId)
            .pipe(map(resolver => `${resolver.firstName} ${resolver.lastName}`))
        : of('');
    // Wait until prerequisites are complete before opening the modal.
    zip(getAuthorName, getResolverName).subscribe(
      ([authorName, resolverName]) => {
        this.authorName = authorName;
        this.resolverName = resolverName;
        this.modal = this.modalService.open(this.content, {
          ariaLabelledBy: 'modal-title',
        });
      }
    );
  }

  formatReimbursementType(): string {
    return ReimbursementType.format(this.reimbursement.type);
  }

  formatReimbursementStatus(): string {
    return ReimbursementStatus.format(this.reimbursement.status);
  }

  shouldShowResolutionControls(): boolean {
    return (
      this.showAdminControls &&
      this.reimbursement.status === ReimbursementStatus.Pending
    );
  }
}
