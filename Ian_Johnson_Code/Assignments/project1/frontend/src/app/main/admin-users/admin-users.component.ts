import { Component, OnInit, ViewChild } from '@angular/core';
import { Observable, of, merge } from 'rxjs';
import { tap, switchMap } from 'rxjs/operators';
import { User } from '../../user';
import { UserService } from '../../user.service';
import { TableColumn } from '../../util/table/table.component';
import { UserRole } from '../../user-role.enum';
import { UserDetailsModalComponent } from './user-details-modal/user-details-modal.component';
import { AddUserModalComponent } from './add-user-modal/add-user-modal.component';
import { MessagingService } from '../../util/messaging.service';

const tableColumns: TableColumn[] = [
  {
    property: 'role',
    title: 'Role',
    formatter: UserRole.format,
  },
  {
    property: 'username',
    title: 'Username',
  },
  {
    property: 'firstName',
    title: 'First name',
  },
  {
    property: 'lastName',
    title: 'Last name',
  },
];

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css'],
})
export class AdminUsersComponent implements OnInit {
  users$: Observable<User[]>;
  tableColumns = tableColumns;
  @ViewChild(UserDetailsModalComponent)
  detailsModal: UserDetailsModalComponent;
  @ViewChild(AddUserModalComponent)
  addUserModal: AddUserModalComponent;

  constructor(
    private messages: MessagingService,
    private userService: UserService
  ) {}

  ngOnInit() {
    // This is kind of an ugly hack to be able to refresh the reimbursements
    // on-demand. I have no idea why I need to merge the messages observable
    // with a constant, but if I take it out, it stops working.
    this.users$ = merge(
      of('refresh'),
      this.messages.getMessages('user-refresh')
    ).pipe(switchMap(_ => this.userService.getAll()));
  }

  addUser({ user, password }: { user: User; password: string }): void {
    this.userService.create(user, password).subscribe(_ => {
      this.refresh();
    });
  }

  refresh(): void {
    this.messages.send('user-refresh', 'refresh');
  }

  openAddUserModal(): void {
    this.addUserModal.open();
  }

  openDetailsModal(u: User): void {
    this.detailsModal.open(u);
  }
}
