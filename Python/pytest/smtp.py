import smtplib
import email.message

def send(fromWho, to, subject, body, server):
  message = email.message.Message()
  message['To'] = to
  message['fromWho'] = fromWho
  message['Subject'] = subject
  message.set_payload(body)

  server = smtplib.SMTP(server)
  res = server.sendmail(fromWho, to, message.as_string())
  server.quit()
  
  return res