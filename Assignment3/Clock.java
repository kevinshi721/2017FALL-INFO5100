/*
2. Find the error in the following code and explain in few lines why it is wrong. (Score 1) 
*/

class Clock { 
// Java will have a default constructor with no-argument if you did not define one
// ERR: no public class in a java file

		String time;
		// since get/set function is defined, marking this property as `private` is recommended.
		
		void getTime(){
		// if use "void", which means there no return value. However, here we used "get" function to get the time, 
		// there will must be a return value, so just remove "void" here. 
		// And add return type here. So this code should be correct to -> String getTime(){
	    // Besides, adding scope of this function is recommended.
				return time;
		}
	    void setTime(String t){
	    		time = t ;
		    	// here we want to give value to the property of object.
		    	// so here it should be changed to "this.time = t;"
		        // Also, adding scope of this function is recommended.
    	}
	
}
