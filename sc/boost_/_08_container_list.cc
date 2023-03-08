#include <boost/container/list.hpp>
#include <cassert>

//Non-copyable and non-movable class
class non_copy_movable
{
   non_copy_movable(const non_copy_movable &);
   non_copy_movable& operator=(const non_copy_movable &);

   public:
   non_copy_movable(int = 0) {}
};

int main ()
{
   using namespace boost::container;

   //Store non-copyable and non-movable objects in a list
   list<non_copy_movable> l;
   non_copy_movable ncm;

   //A new element will be built calling non_copy_movable(int) constructor
   l.emplace(l.begin(), 0);
   assert(l.size() == 1);
   // l.resize(20);

   //A new element will be value initialized
   l.emplace(l.begin());
   assert(l.size() == 1);
   return 0;
}