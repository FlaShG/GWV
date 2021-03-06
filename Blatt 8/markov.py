# heiseticker-text.txt neben dieser Datei ablegen
# starten mit "python markov.py"

import codecs
import re
import random
    
filename = "heiseticker-text.txt"
    
    
dictionary = dict()
previous_word = ""
    
def add_to_dictionary(word, next_word):
    if word in dictionary:
        dictionary[word].append(next_word)
    else:
        dictionary[word] = [next_word]

def get_random_word(p):
    rand = random.random()
    akku = 0
    for word in p:
        akku += p[word]
        if akku >= rand:
            return word

            
print("Scanning words...")

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
            previous_word = word

f.close()


print("Calculating propabilities...")


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
    

print("Done!")
print("You may add a number after your start word to set the sentence length.")
print("Example: \"Wurst 6\" for a 6-words sentence that starts with \"Wurst\".")
    

sentence_length = 8
user_input = input("\nWord please:")
while user_input != "":
    parts = str.split(user_input, " ")
    word = parts[0]
    if len(parts) > 1:
        try:
            sentence_length = int(parts[1])
        except: pass
        
    for i in range(0,sentence_length):
        print(word, end=" ")
        try:
            word = get_random_word(dictionary[word])
        except: break
    user_input = input("\n\nWord please:")
