import arrow

utc = arrow.utcnow()
print utc

a_hour_ago = utc.replace(hours=-1)
print a_hour_ago

local = utc.to('US/Pacific')
print local

print local.format('YYYY-MM-DD HH:mm:ss ZZ')

print local.humanize()
