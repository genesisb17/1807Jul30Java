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
function printShape(shape, height, character) {
  if (height < 0) {
    throw new Error('Cannot make a shape with a negative height.');
  }
  let formatted = '';
  switch (shape) {
    case 'Square':
      for (let i = 0; i < height; i++) {
        formatted += character.repeat(height);
        formatted += '\n';
      }
      break;
    case 'Triangle':
      for (let i = 0; i < height; i++) {
        formatted += character.repeat(i + 1);
        formatted += '\n';
      }
      break;
    case 'Diamond':
      if (height % 2 === 0) {
        throw new Error('Cannot make a diamond with an even height.');
      }
      for (let i = 0; i < Math.floor(height / 2); i++) {
        formatted += ' '.repeat(character.length * (height / 2 - i));
        formatted += character.repeat(2 * i + 1);
        formatted += ' '.repeat(character.length * (height / 2 - i));
        formatted += '\n';
      }
      for (let i = Math.floor(height / 2); i >= 0; i--) {
        formatted += ' '.repeat(character.length * (height / 2 - i));
        formatted += character.repeat(2 * i + 1);
        formatted += ' '.repeat(character.length * (height / 2 - i));
        formatted += '\n';
      }
      break;
    default:
      throw new Error(`${shape} is not a valid shape.`);
  }
  console.log(formatted);
  return formatted;
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(someObj) {
  let output = '';
  for (let prop in someObj) {
    output += `${prop}: ${someObj[prop]}\n`;
  }
  return output;
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.
function deleteElement(someArr) {
  let output = '';
  output += `Initial array: ${someArr}; length ${someArr.length}\n`;
  delete someArr[2];
  output += `After deleting the third element: ${someArr}; length ${
    someArr.length
  }\n`;
  return output;
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.
function spliceElement(someArr) {
  let output = '';
  output += `Initial array: ${someArr}; length ${someArr.length}\n`;
  someArr.splice(3, 1);
  output += `After splicing the third element: ${someArr}; length ${
    someArr.length
  }\n`;
  return output;
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// var john = new Person("John", 30);
function Person(name, age) {
  this.name = name;
  this.age = age;
}

Person.prototype.getName = function() {
  return this.name;
};

Person.prototype.getAge = function() {
  return this.age;
};

Person.prototype.toString = function() {
  return `Name: ${this.getName()}, Age: ${this.getAge()}`;
};

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// var john = getPerson("John", 30);
function getPerson(name, age) {
  // This doesn't use an object literal, but I think it's the best way of doing
  // this. To use an object literal and still have the returned thing be a
  // Person, I'd have to use the __proto__ property, which is deprecated.
  return new Person(name, age);
}

// 14. Display the current time on the top right of your HTML page,
// updating every second

// 15.  Descending order
// Your task is to make a function that can take any non-negative
// integer as a argument and return it with its digits in descending
// order. Essentially, rearrange the digits to create the highest possible number.
function descendingDigits(num) {
  if (num < 0) {
    throw new Error('The input number must be non-negative.');
  } else if (num === 0) {
    return 0;
  }
  // First, let's get the digits as an array.
  const digits = [];
  while (num > 0) {
    digits.push(num % 10);
    num = Math.floor(num / 10);
  }
  // We want to sort in descending order.
  digits.sort((a, b) => b - a);
  // Just for fun, let's use the reduce method to construct the number to
  // return.
  return digits.reduce((num, digit) => 10 * num + digit);
}

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

/**
 * Updates which question is shown on the page, by hiding all others.
 */
function updateShownQuestion() {
  const selectedId = document.getElementById('question-select').value;
  // First, hide all the questions:
  for (const question of document.querySelectorAll('.question')) {
    question.setAttribute('aria-hidden', true);
    question.classList.add('hidden');
  }
  // Now unhide the one we want:
  const selected = document.getElementById(selectedId);
  selected.setAttribute('aria-hidden', false);
  selected.classList.remove('hidden');
}

window.onload = () => {
  // Make the "time" indicator update every second.
  setInterval(() => {
    document.getElementById(
      'time-display'
    ).textContent = new Date().toLocaleTimeString('en-US', { hour12: false });
  }, 1);

  // Set up the question selector.
  updateShownQuestion();
  document
    .getElementById('question-select')
    .addEventListener('change', updateShownQuestion);

  // Set up the questions themselves.
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
  setUpQuestion(8, (shape, height, character) =>
    printShape(shape, parseIntStrict(height), character)
  );
  setUpQuestion(9, input => {
    const obj = JSON.parse(input);
    if (typeof obj !== 'object') {
      throw new Error('Input must be an object.');
    }
    return traverseObject(obj);
  });
  setUpQuestion(10, input => {
    const arr = JSON.parse(input);
    if (!Array.isArray(arr)) {
      throw new Error('Input must be an array.');
    }
    return deleteElement(arr);
  });
  setUpQuestion(11, input => {
    const arr = JSON.parse(input);
    if (!Array.isArray(arr)) {
      throw new Error('Input must be an array.');
    }
    return spliceElement(arr);
  });
  setUpQuestion(12, (name, age) => new Person(name, parseIntStrict(age)));
  setUpQuestion(13, (name, age) => getPerson(name, parseIntStrict(age)));
  setUpQuestion(15, input => descendingDigits(parseIntStrict(input)));
};
