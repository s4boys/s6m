/* quotes on keys are not necessary */
let person = {fullName : "John Doe"};
console.log(person.fullName);

/* in a javascript object the value of a key can be any data
type, even a function */
person = {
    fullName : "Jack Doe",
    getName: function(){
        console.log(this.fullName);
    }
};

person.getName();

/* an example of a javascript object */
person = {
    fullName : "John Doe",
    hobbies : ["tennis", "bowling"]
};

for (let i = 0; i < person.hobbies.length; i++) {
    console.log(person.hobbies[i]);
}

console.log(JSON.stringify(person));

/* parsing a JSON string */
let json_string = '{"fullName" : "John Doe", "hobbies" : ["chess", "football"]}';
person = JSON.parse(json_string);

console.log(person["fullName"], person.hobbies);
