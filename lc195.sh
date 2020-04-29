# Read from the file file.txt and output the tenth line to stdout.
# https://www.cnblogs.com/grandyang/p/5376902.html
awk '{if(NR == 10) print $0}' file.txt