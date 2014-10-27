D3Commands
=========

Some useful commands and other server admin tools. (WIP)

Commands currently included:
* /getuuid [username] [username 2] [...]
* /kill [target player]
* /tps [worldID]
* /tpx <target player> <destination player> OR /tp <target player> [Dimension ID] [x] [y] [z]
* /top
* /heal [target player]
* /feed [target player]
* /fly [target player]
* /god
* /back
* /mem
* /sethome *DOES NOT SAVE OVER SERVER RESTARTS YET!*
* /home

Commands to be added soon:
* /gm
* /tpa (Use json chat formatting to accept, no command)
* ...

Other things to do:
* Add messages to confirm that a command has worked.
* Find out a good way to handle permissions for commands. Idea: built in system like essentials GroupManager
* Maybe figure out a way to split up commands even more (Toggle commands - No args commands - Player only, ...)
* Warps! Each warp saved to a txt file for easy edit/delete plus ingame GUI for lots of fun