#include <boost/algorithm/string.hpp>
#include <iostream>

int main()
{
    using namespace std;
    using namespace boost;
    // https://www.boost.org/doc/libs/1_81_0/doc/html/string_algo/usage.html#id-1.3.3.5.2
    string str1(" hello world! ");
    to_upper(str1);  // str1 == " HELLO WORLD! "
    std::cout << str1 << std::endl;
    trim(str1);      // str1 == "HELLO WORLD!"
    std::cout << str1 << std::endl;

    string str2=
       to_lower_copy(
          ireplace_first_copy(
             str1,"hello","goodbye")); // str2 == "goodbye world!"
    std::cout << str2 << std::endl;
}        