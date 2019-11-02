import re


def parse_file(file_path, amount_relevant_attributes):
    buffer_file = open(file_path, 'r')
    attribute_data = dict()
    for i in range(amount_relevant_attributes):
        file_line = buffer_file.readline()
        raw_data = file_line.split()
        attribute = raw_data[2]
        try:
            word = re.search('([^_]*)$', attribute).group(1)
            attribute_data[word] = float(raw_data[0])
        except AttributeError:
            print("regex parsing error")
    file_line = buffer_file.readline()

    buffer_file.close()
    return attribute_data
