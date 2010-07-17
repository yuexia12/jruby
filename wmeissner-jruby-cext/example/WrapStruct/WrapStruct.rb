# 
# To change this template, choose Tools | Templates
# and open the template in the editor.
 
require 'java'

m = org.jruby.cext.ModuleLoader.new
m.load(self, "wrapstruct")

h = Hello.new
puts "Hello.new returned #{h.inspect}"
puts "h.get_hello returns #{h.get_hello}"

class RubyHello
  def initialize
  end
end

def ruby_hello
 "Hello from Ruby"
end

require 'ffi'
module Foreign
  extend FFI::Library
  ffi_lib FFI::Library::CURRENT_PROCESS
  attach_function :get_hello, :ffi_get_hello, [ ], :string
end

require 'benchmark'

iter = 100_000
10.times do
 Benchmark.bmbm do |bm|
   bm.report("Ruby") { iter.times { RubyHello.new } }
   bm.report("Hello.new") { iter.times { Hello.new } }
 end
end