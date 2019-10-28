import Keywords

class EmailParser:

    def split_email(self,line, delimiter):
        email = line.split(delimiter)
        content = ""
        for text in email[1:-2]:
            content += text.replace("\"","")
        dict = {
            "content": content,
            "ham": email[-1]
        }
        return dict

    def count_words(self,text, occurences):
        index = 0
        words = text.split(Keywords.DELIMITER_WS)
        for word in words:
            if word in occurences:
                occurences[word] += 1
            else:
                occurences[word] = 1

#    def to_arff_format(self, ):
 #       data = list()

    def get_data(self,email,relative_occurences):
        words = email["content"].split(Keywords.DELIMITER_WS)
        for word in words:
            relative_occurences[word] = True

        data_line = ""
        #print(relative_occurences)
        for o in relative_occurences:
            if (relative_occurences[o]):
                data_line += "1,"
            else:
                data_line += "0,"
        data_line += email["ham"]
        return data_line

    def get_attributes(self, occurences):
        result =""
        for word in occurences:
            if (word == "\\"):
                result += Keywords.ATTRIBUTE + " \"" + Keywords.WORD_FREQ + "\\\\" + "\"" + Keywords.ATTRIBUTE_SUFFIX + Keywords.LINE_FEED
            else:
                result += Keywords.ATTRIBUTE + " \"" + Keywords.WORD_FREQ + word + "\"" + Keywords.ATTRIBUTE_SUFFIX + Keywords.LINE_FEED
        result += Keywords.ATTRIBUTE + " \"class" +  "\" " + "{0,1}" + Keywords.LINE_FEED
        return result

    def get_spambase_file(self,path):
        file = open(path,"w+")
        file.write(Keywords.SPAMBASE + Keywords.LINE_FEED)
        return file


#    def get_data(self,):

    def set_occurences_to_false(self,relative_occurences):
        for key in relative_occurences:
            relative_occurences[key] = False
        return relative_occurences

    def parse_emails(self,csv_file):
        output_path = "spam.arff"
        absolute_occurences = dict()
        emails = list()
        for line in csv_file:
            email = self.split_email(line, Keywords.DELIMITER_SC)
            emails.append(email)
            self.count_words(email["content"],absolute_occurences)
        ## dict order can change therefore 2 loops
        arff_file = self.get_spambase_file(output_path)
        arff_file.write(self.get_attributes(absolute_occurences))
        arff_file.write(Keywords.DATA + Keywords.LINE_FEED)

        for email in emails:
            #print(absolute_occurences)
            relative_occurences = self.set_occurences_to_false(dict(absolute_occurences))
            #print(relative_occurences)
            arff_file.write(self.get_data(email,relative_occurences))

        arff_file.close()
