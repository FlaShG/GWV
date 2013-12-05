       

def get_file_contents(filename):
    f = open(filename, 'r')
    lines = []
    for line in f:
        lines.append(line)
    f.close()
    return lines
    

heise_lines = get_file_contents('heise.txt')
print(heise_lines)