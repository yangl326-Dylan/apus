#include <cmath>
#include <iostream>
#include <boost/chrono.hpp>
#include <boost/chrono/chrono_io.hpp>
#include <boost/chrono/floor.hpp>
#include <boost/chrono/round.hpp>
#include <boost/chrono/ceil.hpp>

int main()
{
    using namespace std;
    using namespace boost;

    cout << "milliseconds(1) = "
         <<  boost::chrono::milliseconds(1) << '\n';

    cout << "milliseconds(3) + microseconds(10) = "
         <<  boost::chrono::milliseconds(3) + boost::chrono::microseconds(10) << '\n';

    cout << "hours(3) + minutes(10) = "
         <<  boost::chrono::hours(3) + boost::chrono::minutes(10) << '\n';

    typedef boost::chrono::duration<long long, boost::ratio<1, 2500000000> > ClockTick;
    cout << "ClockTick(3) + boost::chrono::nanoseconds(10) = "
         <<  ClockTick(3) + boost::chrono::nanoseconds(10) << '\n';

   // ...
    return 0;
}