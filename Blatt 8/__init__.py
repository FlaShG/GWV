import codecs
import re
    

def get_file_contents(filename):
    #f = open(filename, 'r')
    f = codecs.open(filename, encoding='utf-8') 
    lines = []
    for line in f:
        #remove \r\n
        nice_line = re.sub("\r\n", lambda x: "", line)
        #only add if long enough (not a symbol like . or , or ")
        if len(nice_line) > 1:
            lines.append(nice_line)
    f.close()
    return lines
    

heise_lines = get_file_contents('heise.txt')
print(heise_lines)

#dictionary = dict()