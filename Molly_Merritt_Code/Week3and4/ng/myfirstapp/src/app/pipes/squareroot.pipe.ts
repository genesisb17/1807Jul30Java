import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqt' // ie {{ 10 | sqt }}
})
export class SquarerootPipe implements PipeTransform {

  transform(value: number): number {
    return Math.sqrt(value);
  }

}
