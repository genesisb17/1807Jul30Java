import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqt' //ie {{10(3) | sqt}}
})
export class SquarerootPipe implements PipeTransform {
  //MUST override transform method
  transform(value: number, args?: any): number {
    return Math.sqrt(value);
  }

}
