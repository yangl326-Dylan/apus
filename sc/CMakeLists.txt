cmake_minimum_required(VERSION 3.0)

# set the project name
project(gflags_test)

SET(SRC_LIST gflags_declare_test.cc)

MESSAGE("SRC_LIST:" ${SRC_LIST})

ADD_DEFINITIONS(
    -Wunused-variable -Wunused-parameter -Wunused-function -Wunused
    -Wno-deprecated -Woverloaded-virtual -Wwrite-strings
    -std=c++11
)

# include_directories(/usr/local/include/)
# find_library(GFLAGS_LIB libgflags.a HINTS /usr/local/lib/*)

find_package(gflags REQUIRED)

# add the executable
add_executable(${PROJECT_NAME} ${SRC_LIST})


# target_link_libraries(${PROJECT_NAME} ${GFLAGS_LIB})
target_link_libraries(${PROJECT_NAME} gflags)
