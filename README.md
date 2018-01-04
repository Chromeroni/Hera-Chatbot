<h1>Hera</h1>
Hera is a Discord chatbot written in Java using the Discord4Java library.

Bot-prefix: $  
Version: v0.4.2

<h2>Available commands</h2>

<h3>help</h3>

Returns a list of all currently available commands.  
>Syntax: $help

<h3>flip</h3>

Flips a coin. Return "Heads" or "Tails" with a 50% chance.  
>Syntax: $flip

<h3>bind</h3>

Binds the output-channel for reports to the channel the command was written in.  
Administrator rights needed for execution.  
>Syntax: $bind

<h3>report</h3>

Sendes a report to the bound channel. Channel needs to be bound in before, else an appropriate error message will appear.  
>Syntax: $report \<@userToReport\> \<reportMessage\>

<h3>teams</h3>

Returns the given parameters / names randomly split into 2 teams.  
>Syntax: $teams \<parameter\> \<parameter\> \<parameter\> ...

<h3>vote</h3>

Startes a vote about the given topic.  
>Syntax: $vote \<topic\>

<h3>yes</h3>

Vote yes for the currently active vote.  
>Syntax: $yes

<h3>no</h3>

Vote no for the currently active vote.  
>Syntax: $no

<h3>end</h3>

End the currently active vote.  
Only usable for the vote organiser or Administrators.
>Syntax: $end

<h3>version</h3>

Returns the current version of Hera.  
>Syntax: $v

<h3>begone</h3>

Moves the user (parameter) to a random channel in the same server for which they have the right permissions.  
The parameter can be a name or nickname, but not a mention (@name).  
>Syntax: $begone \<name/nickname\>

<h3>motd</h3>

Sets the message of the day an writes it in a general channel.  
>Syntax: $motd \<messageOfTheDay\>
