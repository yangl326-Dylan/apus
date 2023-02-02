cmake_minimum_required(VERSION 3.0)

# set the project name
project(boost_tutorials)

SET(ACC_SRC_ _01_accumulators.cc)
SET(STR_ALOG_ _02_str_alogorithm.cc)

SET(FOREACH_ _13_foreach.cc)
SET(LAMDA_SRC_ _18_lamda.cc)

# set boost include dir
SET(Boost_INCLUDE_DIRS /usr/local/include/boost)

MESSAGE("--cmake-- Boost_INCLUDE_DIRS:" ${Boost_INCLUDE_DIRS})

ADD_DEFINITIONS(
    -Wunused-variable -Wunused-parameter -Wunused-function -Wunused
    -Wno-deprecated -Woverloaded-virtual -Wwrite-strings
    -std=c++11
)

# include_directories(/usr/local/include/)
include_directories(${Boost_INCLUDE_DIRS})

# find_library(GFLAGS_LIB libgflags.a HINTS /usr/local/lib/*)
find_package(Boost REQUIRED)

# add the executable
add_executable(_acc ${ACC_SRC_})
add_executable(_str_alog ${STR_ALOG_})

add_executable(_foreach ${FOREACH_})
add_executable(_lamda ${LAMDA_SRC_})

# target_link_libraries(${PROJECT_NAME} ${GFLAGS_LIB})
target_link_libraries(_acc Boost::boost)
target_link_libraries(_str_alog Boost::boost)

target_link_libraries(_foreach Boost::boost)
target_link_libraries(_lamda Boost::boost)

