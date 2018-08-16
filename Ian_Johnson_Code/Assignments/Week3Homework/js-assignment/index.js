// 1. Fibonacci
// Define function: fib(n)
// Return the nth number in the fibonacci sequence.
function fib(n) {
  if (n < 0) {
    throw new Error('Cannot compute Fibonacci numbers with negative indices.');
  }
  let a = 0;
  let b = 1;
  for (let i = 0; i < n; i++) {
    let next = a + b;
    a = b;
    b = next;
  }
  return a;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
  // Note: this implementation modifies the array.
  let sorted = false;
  while (!sorted) {
    // Loop through the array and swap out-of-order elements; do this until we
    // have nothing more to swap.
    let swapped = false;
    for (let i = 0; i < numArray.length - 1; i++) {
      if (numArray[i] > numArray[i + 1]) {
        let tmp = numArray[i];
        numArray[i] = numArray[i + 1];
        numArray[i + 1] = tmp;
        swapped = true;
      }
    }
    if (!swapped) {
      sorted = true;
    }
  }

  return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr) {
  let reversed = '';
  for (let i = someStr.length - 1; i >= 0; i--) {
    reversed += someStr[i];
  }
  return reversed;
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
  if (someNum < 0) {
    throw new Error('Cannot compute the factorial of a negative number.');
  }
  return someNum === 0 ? 1 : someNum * factorial(someNum - 1);
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.
function substring(someStr, length, offset) {
  if (length < 0) {
    alert('Cannot take a substring with a negative length.');
  } else if (offset < 0) {
    alert(`Start index ${offset} is out of bounds.`);
  } else if (length + offset >= someStr.length) {
    alert(`End index ${length + offset} is out of bounds.`);
  } else {
    let substr = '';
    for (let i = offset; i <= length + offset; i++) {
      substr += someStr[i];
    }
    return substr;
  }
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(someNum) {
  return (someNum & 1) === 0;
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr) {
  // Let's make this case-insensitive.
  someStr = someStr.toLowerCase();
  for (let i = 0; i < someStr.length / 2; i++) {
    if (someStr[i] !== someStr[someStr.length - i - 1]) {
      return false;
    }
  }
  return true;
}

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// 	var john = new Person("John", 30);

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// 	var john = getPerson("John", 30);

// 14. Display the current time on the top right of your HTML page,
// updating every second

// 15.  Descending order
// Your task is to make a function that can take any non-negative
// integer as a argument and return it with its digits in descending
// order. Essentially, rearrange the digits to create the highest possible number.

/**
 * A helper function to solve problems. It relies on the fact that the input
 * will always be a field with ID q#-input and the output an element with ID
 * q#-output (where # is the question number). It also takes care of error
 * handling if the provided function throws an error.
 *
 * In the event that the solve function has more than one parameter, the input
 * fields should be named q#-input#, where the second # is the number of the
 * input, starting at 1.
 *
 * @param {number} questionNum The number of the question.
 * @param {function(...string): string} solve The function to use to actually
 * solve the problem.
 * @returns {function(): void} A function that can be invoked when the "compute" button is clicked
 * to actually compute the answer and update the output element.
 */
function doQuestion(questionNum, solve) {
  return () => {
    const inputValues = [];
    if (solve.length === 1) {
      // This is a special case; we don't want to have to number the input
      // fields when there is only one input.
      inputValues.push(document.getElementById(`q${questionNum}-input`).value);
    } else {
      for (let i = 1; i <= solve.length; i++) {
        inputValues.push(
          document.getElementById(`q${questionNum}-input${i}`).value
        );
      }
    }
    const outputElement = document.getElementById(`q${questionNum}-output`);
    try {
      // Note: we can use the so-called "spread" operator (...) to expand an
      // array into arguments to a function.
      outputElement.textContent = solve(...inputValues);
      outputElement.classList.remove('text-danger');
    } catch (e) {
      outputElement.textContent = e;
      outputElement.classList.add('text-danger');
    }
  };
}

/**
 * "Sets up" the given question number with the given solving function (by
 * creating a click event handler on the q${questionNum}-submit button). Note
 * that, along with the doQuestion function, this function only works for
 * problems that take in a single input.
 *
 * @param {number} questionNum The number of the question to set up.
 * @param {function(...string):string} solve The function to use to solve the
 * problem.
 */
function setUpQuestion(questionNum, solve) {
  const submitButton = document.getElementById(`q${questionNum}-submit`);
  submitButton.addEventListener('click', doQuestion(questionNum, solve), true);
}

/**
 * Attempts to parse an integer, throwing an error if this cannot be done.
 *
 * @param {string} str The string to parse.
 * @returns The integer that was parsed.
 */
function parseIntStrict(str) {
  // We'll just use a simple regex to ensure the string is in the right format,
  // but surrounding whitespace isn't important.
  str = str.trim();
  if (/^-?[0-9]+/.test(str)) {
    return parseInt(str, 10);
  } else {
    throw new Error(`'${str}' is not a valid number.`);
  }
}

document.addEventListener('DOMContentLoaded', () => {
  setUpQuestion(1, input => fib(parseIntStrict(input)));
  setUpQuestion(2, input => {
    const arr = JSON.parse(input);
    if (!Array.isArray(arr)) {
      throw new Error('Input must be an array.');
    }
    return JSON.stringify(bubbleSort(arr));
  });
  setUpQuestion(3, reverseStr);
  setUpQuestion(4, input => factorial(parseIntStrict(input)));
  setUpQuestion(5, (str, len, offset) =>
    substring(str, parseIntStrict(len), parseIntStrict(offset))
  );
  setUpQuestion(6, input => isEven(parseIntStrict(input)));
  setUpQuestion(7, isPalindrome);
});
