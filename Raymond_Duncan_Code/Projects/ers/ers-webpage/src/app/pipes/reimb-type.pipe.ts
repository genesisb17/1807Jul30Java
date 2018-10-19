import { Pipe, PipeTransform } from '@angular/core';
import { ReimbType } from '../components/enums/reimb-type';

@Pipe({
  name: 'reimbType'
})
export class ReimbTypePipe implements PipeTransform {

  transform(i: number): string {
    return ReimbType[i].value;
  }

}
