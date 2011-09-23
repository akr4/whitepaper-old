package whitepaper.infrastructure.mail

case class Mail(
  subject: String,
  body: String,
  toAddresses: List[Address],
  ccAddresses: List[Address],
  fromAddress: Address
)

case class Address(
  email: String,
  name: String
)
