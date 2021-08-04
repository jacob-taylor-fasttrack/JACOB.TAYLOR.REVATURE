//Typing is defined upon assignment

//Declaration of a variable
let myVariable;

//to print info to our console, we use console.log
console.log("Hello World");

console.log(typeof myVariable);

myVariable="Word";
console.log(myVariable);
console.log(typeof myVariable);

myVariable=false;
console.log(myVariable);
console.log(typeof myVariable);

/*
JS engages in type coercion to determine
if two variables/values are equivalent disregarding their type
-- performs type coercion where js doesn't regard type in determining equivalency

*/

console.log(10==10)
console.log(10=="10")
console.log(10=='10');

//if you want to enforce type comparison
//===
console.log(10===10)
console.log(10==='10')
console.log(10!='10')
console.log(10!=='10')

/*
js has truthy and falsy values
these are values that evaluate to true or false
there are two aspects involved with truthy/falsy values

    -used in a condition(if/while)
        -when used in a condition EVERYTHING evaluates to true or false
    -used in type coercion(0==false)
        - when used in type coercion, not everything has to evaluate to true or false
*/
console.log()

if(true){
    console.log("Hello World 1")
}
if(false){
    console.log("Hello World 2")
}

if(1){
    console.log("Hello World 3")
}
//1 is a truthy value
if(0){
    console.log("Hello World 4")
}
//0 is a falsy value

//non-zero numbers are truthy values IN conditions
if(null){
    console.log('Hello world 5')
}
//null and undefined are falsy values IN conditions
if(""){
console.log("Hello World 6")
}
if("Anything"){
    console.log('Hello World 7')
}
//empty strings are falsy and non-empty strings are truthy
if('0'){
    console.log("hello world 8")
}
//"0" is truthy in a condition
//Truthy/falsy in type coercion
console.log(true==true)
console.log(false==false)
console.log(true==false)
console.log(true==1)
console.log(false==0)
console(false=="0")//'0' is falsy in type coercion

//Non empty strings are not truthy in type coercion
//Non empty strings are not falsy in type coercion

console.log(true==3)
//Only 1 is truthy and 0 is falsy.Nothing else

//null and undefined is neither truthy nor falsy in type coercion

console.log(null==undefined)//true statement

console.log(10+"5")
console.log('10'+'5')
//both equal 105
console.log(10-'5')
console.log('10'-'5')
//bc of type coercion, both equal 5

console.log('word'-'something')//NaN-> Not a Number

console.log(typeof NaN)//NaN is strangely of type number
//NaN is not equal to NaN
//In conditions,NaN is falsy