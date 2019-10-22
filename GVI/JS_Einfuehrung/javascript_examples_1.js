/* the curly braces are a block statement */
let x = 0;
while (x < 10) {
    console.log(x);
    x++;
}

/* letiable scope */
let y = 1;
{
  let y = 2;
}
console.log(y);

/* conditional statements */
let num = 5;
if (num > 0) {
    console.log("positive");
} else if (num < 0) {
    console.log("negative");
} else {
    console.log("zero");
}

/* switch statement */
let num = 5;
switch (true) {
    case num > 0:
        console.log("positive");
        break;
    case num < 0:
        console.log("negative");
        break;
    default:
        console.log("zero");
        break;
}

/* for statement */
for (let i = 0; i < 10; i++) {
    console.log(i);
}

/* do...while statement */
let i = 0;
do {
  console.log(i);
  i += 1;
} while (i < 5);

/* while statement */
let i = 10;
while (i > 0) {
    console.log(i);
    i--;
}

/* break continue */
let i = 11;
while (i > 0) {
    i--;
    if(i == 7){
        continue;
    }

    if(i < 3){
        break;
    }
    console.log(i);

}

/* for...of statement */
let nums = [3, 5, 7];
for (let n of nums) {
    console.log(n);
}

/* functions */
function underscoreAndUpperCase(input){
    let result = input.toUpperCase();
    result = result.split(' ').join('_');
    return result;
}

console.log(underscoreAndUpperCase("hello to the whole world"));


/* try catch */
function devide(num1, num2){
    if (num2 != 0){
        return num1/num2;
    } else {
        throw "devideByZero";
    }
}

try{
    console.log(devide(4, 2));
    console.log(devide(4, 0));
}catch(e){
    console.log(e);
}


/* function as a class */
function Person(first_name, last_name){
    this.firstName = first_name;
    this.lastName = last_name;
    this.getFullName = function(){
        return this.firstName + " " + this.lastName;
    }
}

let john = new Person('John', 'Doe');
console.log(john.getFullName());
