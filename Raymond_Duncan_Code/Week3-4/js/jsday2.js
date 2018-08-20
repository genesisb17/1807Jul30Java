/* GUARD operator &&
    - if the first operand is truthy, return the second operand, otherwise, it returns the first operatnd
    ***** returns teh actual operand NOT true or false (unless that's the operand)
*/
function guard(op1,op2){
    return op1 && op2;
}


/* DEFAULT operator ||
    - If the first operand is truthy, return it, otherwise return the second operand
*/
function defaultOp(op1,op2){
    return op1 || op2;
}

