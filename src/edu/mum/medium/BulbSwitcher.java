/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.medium;

/**
 *
 * @author hungduong
 */
public class BulbSwitcher {
    /*
     * A bulb ends up on iff it is switched an odd number of times.
     * Call them bulb 1 to bulb n. Bulb i is switched in round d if and only if d divides i. So bulb i ends up on
     * if and only if it has an odd number of divisors.
     * Divisors come in pairs, like i = 12 has divisors 1 and 12, 2 and 6, and 3 and 4. Except when i is a square, like
     * 36 has divisors 1 and 36, 2 and 18, 3 and 12, 4 and 9, and double divisor 6. So bulk i ends up on if and only if
     * i is a square.
     */
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
