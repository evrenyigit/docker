<schema xmlns="http://purl.oclc.org/dsdl/schematron" queryBinding="xslt2">
  <pattern>
    <title>Invoice Structure</title>
    <rule context="Invoice">
      <assert test="id">ID must be present</assert>
      <assert test="invoiceDate">Invoice Date must be present</assert>
      <assert test="typeOfInvoice">Type of Invoice must be present</assert>
      <assert test="totalAmount">Total Amount must be present</assert>
      <assert test="customer">Customer information must be present</assert>
    </rule>
    <rule context="customer">
      <assert test="email">Customer email must be present</assert>
      <assert test="id">Customer ID must be present</assert>
      <assert test="name">Customer name must be present</assert>
    </rule>
  </pattern>
</schema>