package net.cghsystems.inv;

class ContractDetail {
  Integer days
  Double rate
  Double vat

  String toString() {
    "${days} Days @ ${rate}"
  }

  BigDecimal total() {
    totalNoVat().add(vatOfTotal())
  }

  BigDecimal vatOfTotal() {
    BigDecimal totalNoVat = totalNoVat()
    totalNoVat.divide(100).multiply(vat)
  }

  BigDecimal totalNoVat() {
    BigDecimal res = new BigDecimal(rate)
    res.multiply(days)
  }
}
