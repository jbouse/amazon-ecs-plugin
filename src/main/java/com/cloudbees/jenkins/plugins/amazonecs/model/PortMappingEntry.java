/*
 * The MIT License
 *
 *  Copyright (c) 2015, CloudBees, Inc.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 *
 */

package com.cloudbees.jenkins.plugins.amazonecs.model;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import hudson.util.ListBoxModel;

import org.kohsuke.stapler.DataBoundConstructor;

public class PortMappingEntry extends AbstractDescribableImpl<PortMappingEntry> {
    public Integer containerPort, hostPort;
    public String protocol;

    @DataBoundConstructor
    public PortMappingEntry(Integer containerPort, Integer hostPort, String protocol) {
        this.containerPort = containerPort;
        this.hostPort = hostPort;
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "PortMappingEntry{" +
                "containerPort=" + containerPort +
                ", hostPort=" + hostPort +
                ", protocol='" + protocol + "}";
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<PortMappingEntry> {
        public ListBoxModel doFillProtocolItems() {
            final ListBoxModel options = new ListBoxModel();
            options.add("TCP", "tcp");
            options.add("UDP", "udp");
            return options;
        }

        @Override
        public String getDisplayName() {
            return "PortMappingEntry";
        }
    }
}
