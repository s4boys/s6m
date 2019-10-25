

def CountWords(text,occurences):
    words = text.split(" ")
    for word in words:
        if word in occurences:
            occurences[word] += 1
        else:
            occurences[word] = 1



def SplitEmail(line,delimiter):
    email = line.split(delimiter)
    dict =  {
        "subject": email[1],
        "text": email[2],
        "ham" : email[3]
    }
    print(dict)
    return dict

def ReadEmail(path):
    return open(path,"r")

def main():
    delimiter = ";"
    path = "enron.csv"
    subjects = dict()
    #texts = dict()
    file = ReadEmail(path)
    for line in file:
        email = SplitEmail(line,delimiter)
        CountWords(email["subject"],subjects)
        #CountWords(email.text,texts)
    print(subjects)


if __name__ == "__main__":
    main()
