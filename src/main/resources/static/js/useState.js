///////////////////////////////////////////////
///  Getting the values from the input  //////
//////////////////////////////////////////////

 class useStateForProject{

      async useState1  (defaultValue) {
        // ðð»We create a function useState with a default value
        let value = defaultValue;

        // ðð»We create a local variable value = defaultValue
        function  getValue() {
            // ðð»We create a function getValue to get the value that return the value
            return value;
        }

        function setValue(newValue) {
            // ðð»We create a function to set the value with parameter newValue
            value = newValue; // ðð» We change the value for newValue
            //   render(); // ðð»We run the render function on our app
        }

        return [getValue, setValue];
        // ðð»We return an array with the value and the function
     }
 }
