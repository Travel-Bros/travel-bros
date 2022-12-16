///////////////////////////////////////////////
///  Getting the values from the input  //////
//////////////////////////////////////////////

 class useStateForProject{

      async useState1  (defaultValue) {
        // 👆🏻We create a function useState with a default value
        let value = defaultValue;

        // 👆🏻We create a local variable value = defaultValue
        function  getValue() {
            // 👆🏻We create a function getValue to get the value that return the value
            return value;
        }

        function setValue(newValue) {
            // 👆🏻We create a function to set the value with parameter newValue
            value = newValue; // 👈🏻 We change the value for newValue
            //   render(); // 👈🏻We run the render function on our app
        }

        return [getValue, setValue];
        // 👆🏻We return an array with the value and the function
     }
 }
