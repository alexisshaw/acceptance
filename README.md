== COMP2911 Acceptance Test ==
This is the official acceptance testing framework for COMP2911. You can
download the source code by following the instructions above. In this
document we go through the process of building and installing.

=== Building ===
To build the project execute the following shell command from your CSE account
or your home linux or mac computer. Your code should be able to at least run
on the UNSW CSE servers:
{{{
    chmod +x compileAndRun.sh
    ./compileAndRun.sh
}}}


=== Implementing The Interface (unstable) ===
* You are required to place your implementation in AcceptanceImplemenation that
  implements AcceptanceInterface. There are tutorials in doc/ with additional
  information.

=== Requesting Tests ===
* If you are familiar with github:
** Send us a git pull request and we will review your change and imlement it
   if we feel it is a good / correct test. Provide reasoning, non trivial
   changes are prefered.
** If you want a challenge send a patch over mail to bwright@cse.unsw.edu.au
* If you are not familiar with github:
** Send an email to your student representative containing your unit tests.
   try and follow the conventions layed out in the existing tests.

