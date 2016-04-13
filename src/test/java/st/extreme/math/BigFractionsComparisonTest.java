package st.extreme.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class BigFractionsComparisonTest {

  @Test
  public void testCompareTo_equal() {
    BigFraction q1;
    BigFraction q2;

    q1 = new BigFraction("12", "40");
    q2 = new BigFraction("12", "40");
    assertEquals(0, q1.compareTo(q2));
    assertEquals(0, q2.compareTo(q1));
    BigFraction q3 = new BigFraction("12", "40");
    assertEquals(0, q1.compareTo(q3));
    assertEquals(0, q2.compareTo(q3));

    q1 = new BigFraction("12", "-40");
    q2 = new BigFraction("12", "-40");
    assertEquals(0, q1.compareTo(q2));
    assertEquals(0, q2.compareTo(q1));

    q1 = new BigFraction("-12", "40");
    q2 = new BigFraction("12", "-40");
    assertEquals(0, q1.compareTo(q2));
    assertEquals(0, q2.compareTo(q1));

    q1 = new BigFraction("12", "-40");
    q2 = new BigFraction("-12", "40");
    assertEquals(0, q1.compareTo(q2));
    assertEquals(0, q2.compareTo(q1));

    q1 = new BigFraction("-12", "-40");
    q2 = new BigFraction("-12", "-40");
    assertEquals(0, q1.compareTo(q2));
    assertEquals(0, q2.compareTo(q1));
  }

  @Test
  public void testCompareTo_not_equal() {
    BigFraction q1;
    BigFraction q2;

    q1 = new BigFraction("13", "40");
    q2 = new BigFraction("12", "40");
    assertTrue(q1.compareTo(q2) > 0);
    assertTrue(q2.compareTo(q1) < 0);

    q1 = new BigFraction("-13", "40");
    q2 = new BigFraction("-12", "40");
    assertTrue(q1.compareTo(q2) < 0);
    assertTrue(q2.compareTo(q1) > 0);

    q1 = new BigFraction("13", "-40");
    q2 = new BigFraction("12", "-40");
    assertTrue(q1.compareTo(q2) < 0);
    assertTrue(q2.compareTo(q1) > 0);

    q1 = new BigFraction("-13", "40");
    q2 = new BigFraction("12", "-40");
    assertTrue(q1.compareTo(q2) < 0);
    assertTrue(q2.compareTo(q1) > 0);

    q1 = new BigFraction("13", "-40");
    q2 = new BigFraction("-12", "40");
    assertTrue(q1.compareTo(q2) < 0);
    assertTrue(q2.compareTo(q1) > 0);

    q1 = new BigFraction("-13", "-40");
    q2 = new BigFraction("-12", "-40");
    assertTrue(q1.compareTo(q2) > 0);
    assertTrue(q2.compareTo(q1) < 0);
  }

  @Test
  public void testEquals() {
    BigFraction q1 = new BigFraction("12", "40");
    BigFraction q2 = new BigFraction("12", "40");
    assertEquals(q1, q2);
    assertEquals(q2, q1);
    BigFraction q3 = new BigFraction("12", "40");
    assertEquals(q1, q3);
    assertEquals(q2, q3);
  }

  @Test
  public void testEquals_notEqual() {
    BigFraction q1;
    BigFraction q2;
    q1 = new BigFraction("12", "40");
    q2 = new BigFraction("-12", "40");
    assertNotEquals(q1, q2);
    q2 = new BigFraction("12", "41");
    assertNotEquals(q1, q2);
    q2 = new BigFraction("-12", "41");
    assertNotEquals(q1, q2);
    q2 = new BigFraction("11", "40");
    assertNotEquals(q1, q2);
    q2 = new BigFraction("11", "-40");
    assertNotEquals(q1, q2);
  }

  @Test
  public void testEquals_Number() {
    BigFraction bf;

    bf = BigFraction.valueOf("1/4");
    assertEquals(bf, new BigDecimal("0.25"));
    assertNotEquals(bf, new BigDecimal("-0.25"));
    assertEquals(bf, Double.valueOf("0.25"));
    assertEquals(bf, 0.25d);
    assertNotEquals(bf, Double.valueOf("-0.25"));
    assertNotEquals(bf, -0.25d);
    assertEquals(bf, Float.valueOf("0.25"));
    assertEquals(bf, 0.25f);
    assertNotEquals(bf, Float.valueOf("-0.25"));
    assertNotEquals(bf, -0.25f);

    bf = BigFraction.valueOf("4");
    assertEquals(bf, new BigInteger("4"));
    assertNotEquals(bf, new BigInteger("-4"));
    assertEquals(bf, Long.valueOf("4"));
    assertNotEquals(bf, Long.valueOf("-4"));
    assertEquals(bf, 4L);
    assertNotEquals(bf, -4L);
    assertEquals(bf, Integer.valueOf("4"));
    assertNotEquals(bf, Integer.valueOf("-4"));
    assertEquals(bf, 4);
    assertNotEquals(bf, -4);
  }

  @Test
  public void testEquals_someCompletelyOtherObject() {
    BigFraction bf = BigFraction.valueOf("1/4");
    assertNotEquals(bf, "0.25");
  }

  @Test
  public void testHashCode_equal() {
    BigFraction q1;
    BigFraction q2;
    q1 = new BigFraction("-8", "7");
    q2 = new BigFraction("-8000", "7000");
    assertTrue(q1.equals(q2));
    assertEquals(q1.hashCode(), q2.hashCode());
  }

  @Test
  public void testHashCode_multipleCalls() {
    BigFraction q1 = new BigFraction("94382991", "882932");
    int firstHash = q1.hashCode();
    assertEquals(firstHash, q1.hashCode());
    assertEquals(firstHash, q1.hashCode());
  }

}