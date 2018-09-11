import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqt' // ie {{10(3) | sqrt}}
})
export class SquarerootPipe implements PipeTransform {

  // MUST OVERRIDE TRANSFORM METHOD
  transform(value: number): number {
    return Math.sqrt(value);
  }

}
