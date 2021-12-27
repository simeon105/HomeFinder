package com.example.yourlocalpharmacy.Components;

import java.util.ArrayList;
import java.util.List;

public class Pipe {
    private List<Filter> pipes;

    public Pipe() {
        pipes = new ArrayList<>();
    }

    public Object Pipes(Object input)
    {
        for (Filter pipe : pipes)
        {
            input = pipe.Execute(input);
        }
        return input;
    }

    public void changeWithFilter(Filter pipe)
    {
        pipes.add(pipe);
    }
}
