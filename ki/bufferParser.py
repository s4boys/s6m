

def read_file(file_path):
    return open(file_path,'r')

def parse_file(buffer_file, min_value):
    attribute_data = dict()
    file_line = buffer_file.readline()
    while file_line:
        raw_data = file_line.split()
        if float(raw_data[0]) > min_value:
            attribute_data[raw_data[2]] = 1
        file_line = buffer_file.readline()

    buffer_file.close()
    return attribute_data


def main():
    buffer_file = read_file('correlBuffer.txt')
    attribute_data = parse_file(buffer_file, 0)
    print(attribute_data)


if __name__ == "__main__":
    main()
