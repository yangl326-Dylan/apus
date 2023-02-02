#include <iostream>
#include <gflags/gflags.h>

//declare
static bool ValidatePort(const char* flagname, int32_t value);
void print_message();

// define flags
DEFINE_string(msg, "default", "The message to print");
DEFINE_int32(port, 80, "need a port, between 0 and 255");
DEFINE_bool(l, false, "open l args, default false");
DEFINE_bool(n, true, "open n args, default true");

DEFINE_validator(port, &ValidatePort);// inject validator

/**
 * google gflags 工具库学习
 * main test. usage doc: https://gflags.github.io/gflags/
*/
int main(int argc, char **argv)
{
  // GFLAGS_NAMESPACE::SetUsageMessage("Test compilation and use of gflags_declare.h");
  GFLAGS_NAMESPACE::ParseCommandLineFlags(&argc, &argv, true);
  print_message();
  return 0;
}

/**
 *  validate flag
*/
bool ValidatePort(const char* flagname, int32_t value) {
   if (value >= 0 && value < 256)   // value is ok
     return true;
   printf("Invalid value for --%s:%d, port should be between 0 and 255\n", flagname, (int)value);
   return false;
}

/**
 * print flags
*/
void print_message()
{
  std::cout << "message:"<< FLAGS_msg << std::endl;
  std::cout << "port:" << FLAGS_port << std::endl;
  std::cout << "l:" << FLAGS_l << std::endl;
  std::cout << "n:" << FLAGS_n << std::endl;
}

