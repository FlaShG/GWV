import codecs
import re
    
filename = "nicht_heise.txt"
    
    
dictionary = dict()
previous_word = ""
    

#map all following words to all words
f = codecs.open(filename, encoding='utf-8') 
for line in f:
    #remove \r\n
    word = re.sub("\r\n", lambda x: "", line)
    #only add if long enough (not a symbol like . or , or ")
    if len(word) > 1:
        if previous_word == "":
            previous_word = word
        else:
            add_to_dictionary(previous_word, word)

f.close()


#calculate propabilities
for word in dictionary:
    p = dict()
    for follower in dictionary[word]:
        if follower in p:
            p[follower] += 1
        else:
            p[follower] = 1
            
    wordcount = len(dictionary[word])
    
    for follower in p:
        p[follower] /= wordcount
    
    dictionary[word] = p


user_input = input("word please:")
while input("word please:") != "":
    word = user_input
    for i in range(0,5):
        print(word)
        word = get_random_word(dictionary[word])
    user_input = input("word please:")



def add_to_dictionary(word, next_word):
    if word in dictionary:
        dictionary[word].append(next_word)
    else:
        dictionary[word] = [next_word]

def get_random_word(p):
    rand = random.uniform(0.0, 1.0)
    akku = 0
    for word in p:
        akku += p[word]
        if akku >= rand:
            return word
        
        
        
        
        
        