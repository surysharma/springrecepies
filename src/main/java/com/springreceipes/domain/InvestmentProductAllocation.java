package com.springreceipes.domain;

public class InvestmentProductAllocation {
    String productAllocationName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestmentProductAllocation that = (InvestmentProductAllocation) o;

        if (productAllocationName != null ? !productAllocationName.equals(that.productAllocationName) : that.productAllocationName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return productAllocationName != null ? productAllocationName.hashCode() : 0;
    }
}
