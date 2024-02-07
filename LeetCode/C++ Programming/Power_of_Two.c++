#include <math.h>
class Solution {
public:
    bool isPowerOfTwo(int n) {
        
        int ans = 1;
        for(int i = 0;i<=30;i++) {
            
            if(ans == n) {
                return true;
            }
            
            if(ans < INT_MAX / 2) 
                ans = ans *2;
            
        }
        return false;
    }
};


// Easy Solution (Using BrutForce)


// class Solution {
// public:
//     bool isPowerOfTwo(int n) {
        
//         for(int i = 0;i<=30;i++) {
//             int comp = pow(2,i);
            
//             if(comp == n) {
//             return true;
//             }
            
//         }
        
//         return false;
//     }
// };