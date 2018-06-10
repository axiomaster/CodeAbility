package com.axiomaster;

import java.util.List;

public class L638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int res = 0, n = price.size();
        for (int i = 0; i < n; i++) {
            res += price.get(i) * needs.get(i);
        }

        for (List<Integer> sp : special) {
            boolean isValid = true;
            for (int j = 0; j < n; j++) {
                if (needs.get(j) - sp.get(j) < 0) {
                    isValid = false;
                }
                needs.set(j, needs.get(j) - sp.get(j));
            }

            if (isValid) {
                res = Math.min(res, shoppingOffers(price, special, needs) + sp.get(n));
            }
            for (int j = 0; j < n; ++j) {
                needs.set(j, needs.get(j) + sp.get(j));
            }
        }

        return  res;
    }
}
