#import EmailParser.EmailParser as EmailParser
import EmailParser


def read_email(path):
    return open(path, "r")


def main():
    output_path = "spam.arff"
    input = read_email("short_enron4.csv")
    parser = EmailParser.EmailParser()
    parser.parse_emails(input)
    #parser.filter_attributes_by_occurrence(5)
    parser.write_arff_file(output_path)


if __name__ == "__main__":
    main()
