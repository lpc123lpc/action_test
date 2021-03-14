

import java.math.BigInteger;

public class Item implements Comparable<Item> {
    private String flag;
    private BigInteger coe;
    private BigInteger index;

    public Item(String flag,String coe,String index) {
        this.flag = newFlag(flag);
        String newString = this.flag + coe;
        this.coe = new BigInteger(newString);
        this.index = new BigInteger(index);
    }

    public void setCoe(BigInteger coe) {
        this.coe = coe;
    }

    public BigInteger getCoe() {
        return coe;
    }

    public BigInteger getIndex() {
        return index;
    }

    public void addCoe(Item item) {
        BigInteger addCoe =  item.getCoe();
        this.coe = this.coe.add(addCoe);
        if (this.coe.compareTo(BigInteger.ZERO) > 0) {
            this.flag = "+";
        }
        else {
            this.flag = "-";
        }

    }

    public String getFlag() {
        if (flag.equals("+")) {
            if (index.compareTo(BigInteger.ZERO) < 0) {
                return "-";
            }
            else {
                return "+";
            }
        }
        else {
            if (index.compareTo(BigInteger.ZERO) < 0) {
                return "+";
            }
            else {
                return "-";
            }
        }
    }

    public String print() {
        BigInteger newCoe = this.coe.multiply(this.index);
        BigInteger newIndex = this.index.subtract(BigInteger.ONE);
        int cpZero = newCoe.compareTo(BigInteger.ZERO);
        int cpOne = newCoe.compareTo(BigInteger.ONE);
        int cpLow = newCoe.compareTo(new BigInteger("-1"));
        int ipOne = newIndex.compareTo(BigInteger.ONE);
        int ipZero = newIndex.compareTo(BigInteger.ZERO);
        String output = null;
        if (cpZero != 0) {
            if (ipZero == 0) {
                System.out.print(newCoe.abs());
                output = newCoe.abs().toString();
            } else if (cpOne == 0 && ipOne == 0) {
                System.out.print("x");
                output = "x";
            } else if (cpOne == 0) {
                System.out.print("x**" + newIndex);
                output = "x**" + newIndex;
            } else if (cpLow == 0 && ipOne == 0) {
                System.out.print("x");
                output = "x";
            } else if (cpLow == 0) {
                System.out.print("x**" + newIndex);
                output = "x**" + newIndex;
            } else if (ipOne == 0) {
                System.out.print(newCoe.abs() + "*x");
                output = newCoe.abs() + "*x";
            } else {
                System.out.print(newCoe.abs() + "*x**" + newIndex);
                output = newCoe.abs() + "*x**" + newIndex;
            }
        }
        return output;
    }

    public  String newFlag(String flag) {
        if (flag.length() == 2) {
            if (flag.equals("+-") || flag.equals("-+")) {
                return "-";
            }
            else {
                return "+";
            }
        }
        else {
            if (flag.equals("+")) {
                return "+";
            }
            else {
                return "-";
            }
        }
    }

    @Override
    public int compareTo(Item o) {
        if (this.index.compareTo(o.index) < 0) {
            return 1;
        }
        else if (this.index.compareTo(o.index) > 0) {
            return  -1;
        }
        else {
            return 0;
        }
    }
}
