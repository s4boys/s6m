#import EmailParser.EmailParser as EmailParser
import EmailParser


def read_email(path):
    return open(path, "r")


def main():
    input = read_email("short_enron2.csv")
    parser = EmailParser.EmailParser()
    parser.parse_emails(input)


if __name__ == "__main__":
    main()
