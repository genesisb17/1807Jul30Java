import { Pipe, PipeTransform } from '@angular/core';
import { ReimbStatus } from '../components/enums/reimb-status';

@Pipe({
  name: 'reimbStatus'
})
export class ReimbStatusPipe implements PipeTransform {

  transform(i: number): any {
    return ReimbStatus[i].value;
  }
}
