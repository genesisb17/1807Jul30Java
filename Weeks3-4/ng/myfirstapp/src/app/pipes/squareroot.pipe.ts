import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqt' // ie {{ 10 | sqt}
})
export class SquarerootPipe implements PipeTransform {
  // MUST override transform method
  transform(value: number): number {
    return Math.sqrt(value);
  }

}
