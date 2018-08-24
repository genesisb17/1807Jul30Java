import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareroot',
})
export class SquarerootPipe implements PipeTransform {
  // Must override transform method for a pipe.
  transform(value: number): number {
    return Math.sqrt(value);
  }
}
