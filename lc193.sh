# Read from the file file.txt and output all valid phone numbers to stdout.
# https://www.cnblogs.com/grandyang/p/5389375.html
awk '/^([0-9]{3}-|\([0-9]{3}\) )[0-9]{3}-[0-9]{4}$/' file.txt