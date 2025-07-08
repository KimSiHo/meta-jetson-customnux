# sub.py
import zmq

ctx = zmq.Context()
sock = ctx.socket(zmq.SUB)
sock.connect("tcp://127.0.0.1:5555")
sock.setsockopt_string(zmq.SUBSCRIBE, "result")  # 토픽 구독

while True:
    parts = sock.recv_multipart()
    topic = parts[0].decode()
    meta  = parts[1].decode()
    print(f"[{topic}] {meta}")
