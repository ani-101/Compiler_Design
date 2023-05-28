//regular expression

#include <iostream>
#include <regex>
using namespace std;

int main()
{
    string regex_str = "ab*";
    regex regex_pattern(regex_str);
    string input_str;

    cout << "Enter a string: ";
    getline(cin, input_str);

    if (regex_match(input_str, regex_pattern))
    {
        cout << "The string \"" << input_str << "\" matches the regular expression \"" << regex_str << "\"." << endl;
    }
    else
    {
        cout << "The string \"" << input_str << "\" does not match the regular expression \"" << regex_str << "\"." << endl;
    }

    return 0;
}